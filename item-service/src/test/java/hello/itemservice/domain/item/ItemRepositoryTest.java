package hello.itemservice.domain.item;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ItemRepositoryTest {

    ItemRepository itemRepository = new ItemRepository();

    @AfterEach // TEST 끌날 때마다 실행
    void afterEach() {
        // 테스트할 때마다 데이터 지워줌
        itemRepository.clearStore();
    }

    @Test
    void save() {
        //given
        Item item = new Item("itemA", 10000, 10);
        //when
        Item savedItem = itemRepository.save(item);
        //then
        Item findItem = itemRepository.findById(savedItem.getId());
        assertThat(findItem).isEqualTo(savedItem);
    }

    @Test
    void findAll() {
        //given
        Item item1 = new Item("itemA", 10000, 10);
        Item item2 = new Item("itemB", 10000, 10);
        itemRepository.save(item1);
        itemRepository.save(item2);
        //when
        List<Item> findItems = itemRepository.findAll();

        //then
        assertThat(findItems.size()).isEqualTo(2);
        assertThat(findItems.contains(item1)).isEqualTo(true);
        assertThat(findItems.contains(item2)).isEqualTo(true);
    }

    @Test
    void updateItem() {
        //given
        Item item = new Item("itemA", 10000, 10);
        Item savedItem = itemRepository.save(item);
        Long id = savedItem.getId();
        //when
        Item updateParam = new Item("itemB", 5000, 5);
        itemRepository.update(id, updateParam);

        Item findItem = itemRepository.findById(id);
        //then
        assertThat(findItem.getItemName()).isEqualTo(updateParam.getItemName());
        assertThat(findItem.getPrice()).isEqualTo(updateParam.getPrice());
        assertThat(findItem.getQuantity()).isEqualTo(updateParam.getQuantity());
    }
}