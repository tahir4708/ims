package com.ita.if103java.ims.service;

import com.ita.if103java.ims.dto.ItemDto;
import com.ita.if103java.ims.dto.SavedItemDto;
import com.ita.if103java.ims.dto.WarehouseLoadDto;
import com.ita.if103java.ims.entity.Warehouse;

import java.util.List;


public interface ItemService {
    List<ItemDto> findItems();

    SavedItemDto addSavedItem(SavedItemDto savedItemDto);

   ItemDto addItem(ItemDto itemDto);
    boolean softDelete(ItemDto itemDto);

    SavedItemDto findByItemDto(ItemDto itemDto);

    List<Warehouse> findUseFullWarehouses(SavedItemDto savedItemDto);

    boolean moveItem(WarehouseLoadDto warehouseLoadDto, SavedItemDto savedItemDto);

    SavedItemDto outcomeItem(SavedItemDto savedItemDto, int quantity);
}
