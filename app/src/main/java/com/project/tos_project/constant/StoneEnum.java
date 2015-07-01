package com.project.tos_project.constant;

/**
 * Created by LAI on 2015/7/1.
 */
public class StoneEnum {
    public enum Stone {
        //use in 2d stone array
        NULL(0),
        BLUE(1), RED(2), GREEN(3), YELLOW(4), PURPLE(5), PINK(6),
        BLUE_ENCHANTED(7), RED_ENCHANTED(8), GREEN_ENCHANTED(9), YELLOW_ENCHANTED(10), PURPLE_ENCHANTED(11), PINK_ENCHANTED(12) ;

        private int index;

        Stone(int index) {
            this.index = index;
        }

        public int getIndex() {
            return index;
        }
    }
}
