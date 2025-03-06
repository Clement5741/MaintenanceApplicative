package com.gildedrose;

class GildedRose {
    public Item[] items;
    private AbstractItem[] wrappedItems;

    public GildedRose(Item[] items) {
        this.items = items;
        this.wrappedItems = new AbstractItem[items.length];
        for (int i = 0; i < items.length; i++) {
            this.wrappedItems[i] = createItem(items[i]);
        }
    }

    private AbstractItem createItem(Item item) {
        switch (item.name) {
            case "Aged Brie":
                return new AgedBrie(item);
            case "Backstage passes to a TAFKAL80ETC concert":
                return new BackstagePass(item);
            case "Sulfuras, Hand of Ragnaros":
                return new Sulfuras(item);
            default:
                return new NormalItem(item);
        }
    }

    public void updateQuality() {
        for (AbstractItem item : wrappedItems) {
            item.updateQuality();
        }
    }
}
