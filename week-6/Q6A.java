

public class Q6A {
    public static void main(String[] args) {
        // Test Integer
        Integer[] intArray = {1, 3, 5, 7, 2};
        ValueFinder<Integer> integerFinder = new IntegerValueFinder();
        System.out.println("Integer Max: " + integerFinder.findMax(intArray));
        System.out.println("Integer Min: " + integerFinder.findMin(intArray));

        // Test Float
        Float[] floatArray = {1.2f, 3.4f, 2.3f, 5.6f};
        ValueFinder<Float> floatFinder = new FloatValueFinder();
        System.out.println("Float Max: " + floatFinder.findMax(floatArray));
        System.out.println("Float Min: " + floatFinder.findMin(floatArray));

        // Test Character
        Character[] charArray = {'a', 'z', 'b', 'd'};
        ValueFinder<Character> charFinder = new CharacterValueFinder();
        System.out.println("Character Max: " + charFinder.findMax(charArray));
        System.out.println("Character Min: " + charFinder.findMin(charArray));

        // Test String
        String[] stringArray = {"apple", "orange", "banana", "grape"};
        ValueFinder<String> stringFinder = new StringValueFinder();
        System.out.println("String Max: " + stringFinder.findMax(stringArray));
        System.out.println("String Min: " + stringFinder.findMin(stringArray));
    }
}
// Define a generic interface for finding max and min values
 interface ValueFinder<T extends Comparable<T>> {
    T findMax(T[] array);
    T findMin(T[] array);
}
 class IntegerValueFinder implements ValueFinder<Integer> {
    @Override
    public Integer findMax(Integer[] array) {
        if (array == null || array.length == 0) return null;
        Integer max = array[0];
        for (Integer value : array) {
            if (value.compareTo(max) > 0) {
                max = value;
            }
        }
        return max;
    }

    @Override
    public Integer findMin(Integer[] array) {
        if (array == null || array.length == 0) return null;
        Integer min = array[0];
        for (Integer value : array) {
            if (value.compareTo(min) < 0) {
                min = value;
            }
        }
        return min;
    }
}
 class FloatValueFinder implements ValueFinder<Float> {
    @Override
    public Float findMax(Float[] array) {
        if (array == null || array.length == 0) return null;
        Float max = array[0];
        for (Float value : array) {
            if (value.compareTo(max) > 0) {
                max = value;
            }
        }
        return max;
    }

    @Override
    public Float findMin(Float[] array) {
        if (array == null || array.length == 0) return null;
        Float min = array[0];
        for (Float value : array) {
            if (value.compareTo(min) < 0) {
                min = value;
            }
        }
        return min;
    }
}
 class CharacterValueFinder implements ValueFinder<Character> {
    @Override
    public Character findMax(Character[] array) {
        if (array == null || array.length == 0) return null;
        Character max = array[0];
        for (Character value : array) {
            if (value.compareTo(max) > 0) {
                max = value;
            }
        }
        return max;
    }

    @Override
    public Character findMin(Character[] array) {
        if (array == null || array.length == 0) return null;
        Character min = array[0];
        for (Character value : array) {
            if (value.compareTo(min) < 0) {
                min = value;
            }
        }
        return min;
    }
}

 class StringValueFinder implements ValueFinder<String> {
    @Override
    public String findMax(String[] array) {
        if (array == null || array.length == 0) return null;
        String max = array[0];
        for (String value : array) {
            if (value.compareTo(max) > 0) {
                max = value;
            }
        }
        return max;
    }

    @Override
    public String findMin(String[] array) {
        if (array == null || array.length == 0) return null;
        String min = array[0];
        for (String value : array) {
            if (value.compareTo(min) < 0) {
                min = value;
            }
        }
        return min;
    }
}
