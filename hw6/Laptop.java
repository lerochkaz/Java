package home_work.hw6;

import java.util.HashMap;
import java.util.Map;

public class Laptop {

    HashMap<String, String> computer;

    public Laptop(String model, String ram, String ssd, String operatingSystem, String color) {
        computer = new HashMap<>();
        computer.put("model", model);
        computer.put("ram", ram);
        computer.put("ssd", ssd);
        computer.put("operatingSystem", operatingSystem);
        computer.put("color", color);
    }

    public String toString() {
        return computer.get("model") + ", оперативная память: " + computer.get("ram") + "Гб, объем жесткого диска: "
                + computer.get("ssd")
                + "Гб, операционная система: "
                + computer.get("operatingSystem") + ", цвет: "
                + computer.get("color");
    }

    public boolean compareLaptop(HashMap<String, String> criterions) {
        HashMap<String, String> shapeLaptop = this.computer;
        int count = 0;
        for (Map.Entry value : criterions.entrySet()) {
            if (value.getKey().equals("ram") || value.getKey().equals("ssd")) {
                if (Integer.parseInt(value.getValue().toString()) <= Integer
                        .parseInt(shapeLaptop.get(value.getKey()))) {
                    count++;
                }
            } else {
                if (value.getValue().equals(shapeLaptop.get(value.getKey()))) {
                    count++;
                }
            }
        }
        if (criterions.size() == count) {
            return true;
        } else {
            return false;
        }
    }

}
