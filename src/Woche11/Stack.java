package Woche11;


public class Stack {
    private class StackItem {
        int data;
        StackItem next;

        /*public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("---");
            sb.append(data).append("---");
            return sb.toString();
        }*/

    }

    private StackItem head;

    //globale variable zählt elemente im Stack
    private int index = 0;


    // start push method
    public void push(int data) {
        StackItem element = new StackItem();
        element.data = data;
        element.next = null;

        if(head == null){
            head = element;
        }else{
            StackItem e = head;
            while(e.next != null){
                e = e.next;
            }
            e.next = element;
        }
        index++;

    }
    // end push method


    // start size() method
    public int size() {
        return index;
    }
    // end size() method


    //start pop() method
    public int pop() {

        int position = index-1;
        StackItem runElement = head;

        int infoElement = -1;
        if(position == 0){
            infoElement = runElement.data;
            runElement = runElement.next;
            head = runElement;
        } else if (0 < position && position < index-1){
            int counter=0;
            do{
                if (position-1 == counter){
                    infoElement = runElement.next.data;
                    runElement.next = runElement.next.next;
                }
                counter++;
                runElement = runElement.next;
            }while(runElement.next != null);


        }else if(position == index - 1){
            int counter = 0;
            do {
                if (position-1 == counter){
                    infoElement = runElement.next.data;
                    runElement.next = null;
                }
                counter++;
                if (runElement.next != null){
                    runElement = runElement.next;
                }
            }while(runElement.next != null);
        }else{
            infoElement=0;
        }
        index--;
        return infoElement;
    }
    //end pop() method

    //start ausgabe methode
    public void print() {
        StackItem element = head;
        while(element.next != null){
            System.out.println(element.data);
            element = element.next;
        }
        System.out.println(element.data);
    }
    //end ausgabe methode

    //start peek() methode
    public StackItem peek(){
        StackItem runElement = head;
        StackItem infoElement;
        do {


            if (runElement.next != null){
                runElement = runElement.next;
            }

        }while(runElement.next != null);
        infoElement = runElement;
        return infoElement;
    }
    //end peek() methode


    //start pop() multiple elements
    public int[] pop(int amount){
        int arrayOfElementsData[] = new int[amount];

        int position = index- amount;
        index = index - amount;
        StackItem runElement = head;
        int count = 1;
        int countArray =0;


        do{

            if (position < count){
                arrayOfElementsData[countArray] = runElement.data;

                countArray++;
            }



            runElement = runElement.next;
            count++;

            if (runElement.next == null){
                arrayOfElementsData[countArray] = runElement.data;

            }

        }while(runElement.next != null);
        //nochmal durchlaufen und notes löschen = null setzen
        runElement = head;
        count = 1;

        do{
            if (count == position){
                runElement.next = null;
            }
            count++;
            if (runElement.next != null){
                runElement = runElement.next;
            }
        }while(runElement.next != null);
        return arrayOfElementsData;
    }
    //end pop() multiple elements


}
