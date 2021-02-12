
import java.util.ArrayList;
import java.util.List;

public class Example
{
    public static void main(String[] args)
    {
        // Say we have 3 boxes with contents
        String box1 = "gold";
        String box2 = "silver";
        String box3 = "copper";

        System.out.println("please pick a box: ");
        System.out.println("1 = box1");
        System.out.println("2 = box2");
        System.out.println("3 = box3");

        // lets say user picks 1
        int choice = 1;

        if(choice == 1)
        {
            System.out.println(box1);
        }
        else if(choice == 2)
        {
            System.out.println(box2);
        }
        else if(choice == 3)
        {
            System.out.println(box3);
        }

        // alternatively we can do this
        // NOTE: (collections in java are 0 indexed, this means they start from position 0)
        // so it looks something like this {0, 1, 2, 4, 5, 6, 7, 8, 9}

        List<String> boxes = new ArrayList<>();
        boxes.add(box1); // position 0, first in list
        boxes.add(box2); // position 1, second in list
        boxes.add(box3); // position 2, third in list

        for(int i = 0; i < boxes.size(); i++)
        {
            System.out.println(i + " - for box with " + boxes.get(i));
        }

        // lets assume they picked the first box which will be 0
        int newChoice = 0;

        System.out.println(boxes.get(newChoice));

        // now lets go another step further with this
        Box aBox = new Box("gold");
        Box anotherBox = new Box("silver");
        Box bBox2 = new Box("diamonds");
        Box brokenBox = new Box("junk");

        List<Box> someBoxes = new ArrayList<>();
        someBoxes.add(aBox);
        someBoxes.add(anotherBox);
        someBoxes.add(bBox2);
        someBoxes.add(brokenBox);


        for(int i = 0; i < someBoxes.size(); i++)
        {
            System.out.println(i + " - for box with " + someBoxes.get(i).getContents());
        }

        //lets assume they picked bBox2
        int boxPicked = 2;

        System.out.println(someBoxes.get(boxPicked).getContents());
    }

    private static class Box {
        private String contents;

        public Box(final String contents)
        {
            this.contents = contents;
        }

        public String getContents()
        {
            return contents;
        }
    }

}
