package com.xie.service.impl;

import com.xie.bean.Address;
import com.xie.bean.AddressWithName;
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
    public AddressWithName selectWithNameByPrimaryKey(Integer id) {
        AddressWithName addressWithName = addressMapper.selectWithNameByPrimaryKey(id);
        addressWithName.setFullRegion(addressWithName.getProvinceName() + addressWithName.getCityName() + addressWithName.getDistrictName());
        return addressWithName;
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
    public List<AddressWithName> selectWithNameByUid(Integer uid) {
        List<AddressWithName> list = addressMapper.selectWithNameByUid(uid);
        list.forEach(addressWithName -> addressWithName.setFullRegion(addressWithName.getProvinceName() + addressWithName.getCityName() + addressWithName.getDistrictName()));
        return list;
    }

    @Override
    public Address selectDefaultByUid(Integer uid) {
        return addressMapper.selectDefaultByUid(uid);
    }

    @Override
    public int updateDefaultByUid(Integer uid) {
        return addressMapper.updateDefaultByUid(uid);
    }
}
