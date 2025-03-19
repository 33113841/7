package com.example.a7;


    import java.io.Serializable;

    public class BasketItem implements Serializable {
        private Pet pet;
        private int quantity;

        public BasketItem(Pet pet, int quantity) {
            this.pet = pet;
            this.quantity = quantity;
        }

        public Pet getPet() {
            return pet;
        }

        public int getQuantity() {
            return quantity;
        }
    }

