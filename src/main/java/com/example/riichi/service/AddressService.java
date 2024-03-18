package com.example.riichi.service;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.example.riichi.model.AddressModel;
import com.example.riichi.repository.AddressRepository;

import jakarta.transaction.Transactional;
 
 
@Service
@Transactional
public class  AddressService{
 
    @Autowired
    private AddressRepository repository;
 
    /**
     * 学生一覧の取得
     * @return List<Gakusei>
     */
    public List<AddressModel> getGakuseiList() {
        List<AddressModel> entityList = this.repository.findAll();
        return entityList;
    }
 
    /**
     * 詳細データの取得
     * @param @NonNull Long index
 
     */
    public AddressModel get(@NonNull Long index) {
        AddressModel gakusei = this.repository.findById(index).orElse(new AddressModel());
        return gakusei;
    }
 
    public void save(@NonNull AddressModel AddressModel) {
        this.repository.save(AddressModel);
    }
 
    /**
     * アドレス帳データの削除
     * @param @NonNull Long index
     */
    public void delete(@NonNull Long index) {
        this.repository.deleteById(index);
    }
}