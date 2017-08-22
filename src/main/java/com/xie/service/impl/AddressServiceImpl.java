package com.xie.service.impl;

import com.xie.bean.Address;
import com.xie.mapper.AddressMapper;
import com.xie.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xie on 17/8/22.
 */
@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressMapper addressMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return addressMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Address record) {
        return addressMapper.insert(record);
    }

    @Override
    public int insertSelective(Address record) {
        return addressMapper.insertSelective(record);
    }

    @Override
    public Address selectByPrimaryKey(Integer id) {
        return addressMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Address record) {
        return addressMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Address record) {
        return addressMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Address> selectByUid(Integer uid) {
        return addressMapper.selectByUid(uid);
    }

    @Override
    public Address selectDefaultByUid(Integer uid) {
        return addressMapper.selectDefaultByUid(uid);
    }
}
