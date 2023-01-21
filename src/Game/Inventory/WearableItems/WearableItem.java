package Game.Inventory.WearableItems;

public abstract class WearableItem {

        private int typeId;
        private String type;

        public WearableItem(int typeId, String type) {
                this.typeId = typeId;
                this.type = type;
        }

        public int getTypeId() {
                return typeId;
        }

        public void setTypeId(int typeId) {
                this.typeId = typeId;
        }

        public String getType() {
                return type;
        }

        public void setType(String type) {
                this.type = type;
        }
}
