package com.ita.if103java.ims.dao;

import com.ita.if103java.ims.dto.EndingItemsDto;
import com.ita.if103java.ims.dto.PopularItemsDto;
import com.ita.if103java.ims.dto.PopularItemsRequestDto;
import com.ita.if103java.ims.dto.WarehouseLoadDto;
import com.ita.if103java.ims.dto.WarehousePremiumStructDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DashboardDao {
    List<WarehouseLoadDto> findWarehouseLoadByAccountId(Long accountId);

    List<PopularItemsDto> findPopularItems(PopularItemsRequestDto popularItems, Long accountId);

    Page<EndingItemsDto> findEndedItemsByAccountId(Pageable pageable, int minQuantity, Long accountId);

    WarehousePremiumStructDto getPreLoadByAccounId(Long id, Long accountId);
}
