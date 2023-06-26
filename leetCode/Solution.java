
import java.util.HashMap;

class Solution {
    
    public int romanToInt(String s) {
        
        char[] r = s.toCharArray();
        HashMap<Character, Integer> losninger = new HashMap<Character, Integer>(); 

        losninger.put('I', 1);
        losninger.put('V', 5);
        losninger.put('X', 10);
        losninger.put('L', 50);
        losninger.put('C', 100);
        losninger.put('D', 500);
        losninger.put('M', 1000);

        Integer teller = 0;
        
        for (int i = 0; i < r.length; i++){
           
            char c = r[i];
           
            if (i < r.length-1){
                if (c == 'I'){
                    if (r[i+1] == 'V'){
                        teller = teller + 4;
                        i++;
                        continue;
                        
                    }
                    if (r[i+1] == 'X'){
                        teller = teller + 9;
                        i++;
                        continue;
                    }
                }

                else if (c == 'X'){
                    if (r[i+1] == 'L'){
                        teller = teller + 40;
                        i++;
                        continue;
                    }

                    if (r[i+1] == 'C'){
                        teller = teller + 90;
                        i++;
                        continue;
                    }
                }

                else if (c == 'C'){
                    if (r[i+1] == 'D'){
                        teller = teller + 400;
                        i++;
                        continue;
                    }
                    if (r[i+1] == 'M'){
                        teller = teller + 900;
                        i++;
                        continue;
                    }
                }
                teller = teller + losninger.get(c);
                
            }
            else {
                teller = teller + losninger.get(c);
            }
        }

        return teller;
    }
}