package com.gildedrose;

class AgedBrie extends AbstractItem {
    public AgedBrie(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        increaseQuality();
        item.sellIn--;
        if (item.sellIn < 0) {
            increaseQuality();
        }
    }
}