package opensource.shop.service;

import lombok.RequiredArgsConstructor;
import opensource.shop.domain.item.Book;
import opensource.shop.domain.item.Item;
import opensource.shop.repository.ItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    //상품 저장
    @Transactional
    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    //상품 수정
    @Transactional
    public void updateItem(Long itemId, String name, int price, int stockQuantity) {
        Item findItem = itemRepository.findOne(itemId);
        findItem.setName(name);
        findItem.setPrice(price);
        findItem.setStockQuantity(stockQuantity);
    }

    //모든 상품 조회
    public List<Item> findItems() {
        return itemRepository.findAll();
    }

    //특정 상품 조회
    public Item findOne(Long itemId) {
        return itemRepository.findOne(itemId);
    }
}
