package com.gildedrose;

class NormalItem extends AbstractItem {
    public NormalItem(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        decreaseQuality();
        item.sellIn--;
        if (item.sellIn < 0) {
            decreaseQuality();
        }
    }
}
