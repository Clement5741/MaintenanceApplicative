package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateItem(item);
        }
    }

    private void updateItem(Item item) {
        switch (item.name) {
            case "Aged Brie":
                updateAgedBrie(item);
                break;
            case "Backstage passes to a TAFKAL80ETC concert":
                updateBackstagePasses(item);
                break;
            case "Sulfuras, Hand of Ragnaros":
                return; // Sulfuras ne change jamais
            default:
                updateNormalItem(item);
                break;
        }

        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.sellIn--;
        }

        if (item.sellIn < 0) {
            handleExpiredItem(item);
        }
    }

    private void updateAgedBrie(Item item) {
        increaseQuality(item);
        if (item.sellIn <= 0) {
            increaseQuality(item);
        }
    }

    private void updateBackstagePasses(Item item) {
        increaseQuality(item);
        if (item.sellIn < 11) {
            increaseQuality(item);
        }
        if (item.sellIn < 6) {
            increaseQuality(item);
        }
    }

    private void updateNormalItem(Item item) {
        decreaseQuality(item);
    }

    private void handleExpiredItem(Item item) {
        if (item.name.equals("Aged Brie")) {
            increaseQuality(item);
        } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            item.quality = 0;
        } else {
            decreaseQuality(item);
        }
    }

    private void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
    }

    private void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality--;
        }
    }
}
