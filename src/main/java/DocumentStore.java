import java.util.*;

public class DocumentStore {
    private Collection<String> documents ;
    private int capacity;

    public DocumentStore(int capacity) {
        documents = new ArrayList<>();
        this.capacity = capacity;
    }
    public int getCapacity() {
        return capacity;
   }

   public Collection<String> getDocuments() {
        return documents;
   }

   public void addDocument(String document) {
        if(this.documents.size() > capacity) throw new IllegalStateException();

        documents.add(document);
   }

   public String toString() {
       System.out.println(documents.size() + " ," + capacity);
        return String.format("Document store : %d/%d",documents.size(), capacity);
   }

    static boolean isInteger(String s) { //정수 판별 함수
        try {
            Integer.parseInt(s);
            return true;
        } catch(NumberFormatException e) {  //문자열이 나타내는 숫자와 일치하지 않는 타입의 숫자로 변환 시 발생
            return false;
        }
    }
   public static List<String> changeDateFormat(List<String> dates) {
        // 2010/03/30 , 15/12/2016 , 11-15-2012 만 가능 20100330 20161215 20121115
       List<String> answer = new LinkedList<>();
       for(int i=0; i<dates.size();i++) {

            if(dates.get(i).contains("-")) {
                //check format
                if(!(dates.get(i).charAt(2) == '-' && dates.get(i).charAt(5) == '-')) continue;

                String[] split = dates.get(i).split("-");
                if(isInteger(split[0]) && isInteger(split[1]) && isInteger(split[2]))
                {
                    answer.add(new StringBuilder().append(split[2]).append(split[0]).append(split[1]).toString());
                }

            }
            else if(dates.get(i).contains(("/"))) {
                //check format
                if(!((dates.get(i).charAt(4) == '/' && dates.get(i).charAt(7) == '/')
                        || (dates.get(i).charAt(2) == '/' && dates.get(i).charAt(5) =='/'))) continue;

                String[] split = dates.get(i).split("/");

                if(split[0].length() == 4) {
                    if(isInteger(split[0]) && isInteger(split[1]) && isInteger(split[2]))
                    {
                        answer.add(new StringBuilder().append(split[0]).append(split[1]).append(split[2]).toString());
                    }


                } else {
                    if(isInteger(split[0]) && isInteger(split[1]) && isInteger(split[2]))
                    {
                        answer.add(new StringBuilder().append(split[2]).append(split[1]).append(split[0]).toString());
                    }


                }
           }
       }
       return answer;
   }

   public static void main(String[] args) {
        Map<String,Integer> m = new HashMap<>();
       Vector<String> v = new Vector<>();
       v.add("hi");
       v.set(0,"send");
        List<String> dates = changeDateFormat(Arrays.asList("20--1--0-0", "20150310","2012/03/15", "2010/03/30", "15/12/2016", "04-15-2012"));

        if(dates.size() !=0 ) {
            for(String date : dates) {
                System.out.println(date);
            }
        }

    }
}
