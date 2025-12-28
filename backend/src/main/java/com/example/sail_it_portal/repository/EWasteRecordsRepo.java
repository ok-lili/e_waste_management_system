package com.example.sail_it_portal.repository;

import com.example.sail_it_portal.model.EWasteRecords;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
@Repository
public interface EWasteRecordsRepo extends JpaRepository<EWasteRecords, Integer> {

    List<EWasteRecords> findByDisposalMethod(String disposalMethod);

    List<EWasteRecords> findByAssetId(Integer assetId);

    List<EWasteRecords> findByDisposalDate(Date disposalDate);

    List<EWasteRecords> findByRecyclerName(String recyclerName);
}
