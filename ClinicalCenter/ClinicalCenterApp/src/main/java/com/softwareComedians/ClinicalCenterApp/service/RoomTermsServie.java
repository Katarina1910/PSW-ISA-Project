package com.softwareComedians.ClinicalCenterApp.service;

import com.softwareComedians.ClinicalCenterApp.model.RoomTerms;
import com.softwareComedians.ClinicalCenterApp.repository.RoomTermRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomTermsServie {

    @Autowired
    private RoomTermRepository roomTermRepository;

    public List<RoomTerms> findAll() { return roomTermRepository.findAll(); }

    public RoomTerms save(RoomTerms roomTerms) {
        return  roomTermRepository.save(roomTerms);
    }

}
