package com.example.test.demo.Service;

import com.example.test.demo.DTO.*;
import com.example.test.demo.Entity.Store;
import com.example.test.demo.Repository.BusinessTimesReposity;
import com.example.test.demo.Repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Transactional
public class StoreService  {
    @Autowired
    StoreRepository storeRepository;
    @Autowired
    BusinessTimesReposity businessTimesReposity;


    SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat timeFormat=new SimpleDateFormat("HH:mm");
    String[] weekDay = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
    Calendar cal = Calendar.getInstance();
    int num = cal.get(Calendar.DAY_OF_WEEK)-1;
    final Calendar cal1 = Calendar.getInstance();
    final Calendar cal2 = Calendar.getInstance();
    String Tomorrow1="";
    String Tomorrow2="";
    String today = weekDay[num];
    String date=simpleDateFormat.format(new Date());
    Date datetime;

    {
        try {
            datetime = timeFormat.parse(timeFormat.format(new Date()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    long timeint=datetime.getTime();

    public Store save(StoreDTO storeDTO) {
        for (int i = 0; i <storeDTO.getBusinessTimes().size() ; i++) {
            businessTimesReposity.save(storeDTO.getBusinessTimes().get(i));
        }
        Store store=new Store(storeDTO);
        return storeRepository.save(store);
    }

    public int holidayssave(StoreDTO storeDTO) {
        Store store=new Store(storeDTO);
        return storeRepository.holidayssave(store);
    }

    public ArrayList<ListDTO> list() throws ParseException {

        ArrayList<ListDTO> arrayList=new ArrayList<ListDTO>();
        List <Store> list=storeRepository.list();
        for (int i = 0; i <list.size(); i++) {
            ListDTO listDTO= new ListDTO();
            listDTO.setName(list.get(i).getName());
            listDTO.setDescription(list.get(i).getDescription());
            listDTO.setLevel(list.get(i).getLevel());

            if(list.get(i).getHolidays()!=null){
                for (int j = 0; j <list.get(i).getHolidays().length ; j++) {
                    if(list.get(i).getHolidays()[j].equals(date)) {
                        listDTO.setBusinessStatus("HOLIDAY");
                        break;
                    }
                }
            }
            if(listDTO.getBusinessStatus()!=null){
                arrayList.add(listDTO);
                break;
            }
                for (int j = 0; j < list.get(i).getBusinessTimes().size(); j++) {
                    if (list.get(i).getBusinessTimes().get(j).getDay().equals(today)) {
                        String close= list.get(i).getBusinessTimes().get(j).getClose();
                        String open= list.get(i).getBusinessTimes().get(j).getOpen();
                        long closeint=timeFormat.parse(close).getTime();
                        long openint=timeFormat.parse(open).getTime();

                        if(timeint<closeint&&timeint>openint){
                            listDTO.setBusinessStatus("OPEN");
                            break;
                        }else{
                            listDTO.setBusinessStatus("CLOSE");
                            break;
                        }
                    } else {
                        listDTO.setBusinessStatus("CLOSE");
                    }
                }

            arrayList.add(listDTO);
        }
        return arrayList;
    }

    public ListDetailDTO listdetail(Long id) throws ParseException {
        cal1.add(Calendar.DATE,1);
        cal2.add(Calendar.DATE,2);
        Tomorrow1=simpleDateFormat.format(cal1.getTime());
        Tomorrow2=simpleDateFormat.format(cal2.getTime());
        int cnt=0;
        Store store=storeRepository.listdetail(id);
        ListDetailDTO listDetailDTO =new ListDetailDTO(store);
        ArrayList<BusinessDaysDTO> arrayList=new ArrayList<BusinessDaysDTO>();
        for (int i = 0; i < store.getBusinessTimes().size(); i++) {
            if(store.getBusinessTimes().get(i).getDay().equals(today)){
                cnt=i;
                break;
            }
        }
        for (int i = cnt; i <store.getBusinessTimes().size() ; i++) {
            BusinessDaysDTO daysDTO=new BusinessDaysDTO();
            daysDTO.setDay(store.getBusinessTimes().get(i).getDay());
            daysDTO.setOpen(store.getBusinessTimes().get(i).getOpen());
            daysDTO.setClose(store.getBusinessTimes().get(i).getClose());

            if(store.getHolidays()!=null){
                for (int j = 0; j <store.getHolidays().length ; j++) {
                    if(store.getHolidays()[j].equals(date)){
                        daysDTO.setStatus("HOLIDAY");
                        break;
                    }
                }
            }
            if(daysDTO.getStatus()!=null){
                arrayList.add(daysDTO);
                continue;
            }

                String close= daysDTO.getClose();
                String open= daysDTO.getOpen();
                long closeint=timeFormat.parse(close).getTime();
                long openint=timeFormat.parse(open).getTime();

                if(timeint<closeint&&timeint>openint){
                    daysDTO.setStatus("OPEN");
                }else{
                    daysDTO.setStatus("CLOSE");
                }
            arrayList.add(daysDTO);
            continue;

        }
        listDetailDTO.setBusinessDays(arrayList);
        return listDetailDTO;
    }

    public void delete(Long id) {
        storeRepository.deleteById(id);
    }
}
