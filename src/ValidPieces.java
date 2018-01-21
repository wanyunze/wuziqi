import java.util.HashSet;
import java.util.Set;

/**
 * Created by 万运泽 on 2018/1/17.
 */
public class ValidPieces {
    // 棋盘格子以 "A1" "B3"这种方式表明， 如果有多个棋子把它变成一个String “A1B3G3"如此。
    // 棋子必须得在棋盘上 并且不能有重复的

    //单一棋子function
    static boolean isPlacementWellFormed(String placement) {
        char[] placementArray = placement.toCharArray();
        char validLetter = 'A';
        char validNumber = '1';
        char validNumberInt = 10;
        boolean letterCheck = false;
        boolean numberCheck = false;
        // Check if letter it's in range between 'A' - 'O'
        while (validLetter <= 'O') {
            if (placementArray[0] == validLetter) {
                letterCheck = true;
                break;
            } else {
                validLetter++;
            }
        }
        // check if the length is between 2-3, if it's only length of 2. check if it's between 1-9;
        if (placementArray.length == 2) {
            while (validNumber <= '9') {
                if (placementArray[1] == validNumber) {
                    numberCheck = true;
                    break;
                } else {
                    validNumber++;
                }
            }
        }
        // if it's length of 3. convert the string to number and check if it's between 10-15
        else if (placementArray.length == 3) {
            String numberString = placementArray[1] + "" + placementArray[2];
            // if It's not number, throw exception to avoid bugs
            try {
                Integer.parseInt(numberString);
            } catch (NumberFormatException e) {
                return false;
            }
            int number = Integer.parseInt(numberString);
            while (validNumberInt <= 15) {
                if (number == validNumberInt) {
                    numberCheck = true;
                    break;
                } else {
                    validNumberInt++;
                }
            }
        }
        // if the length is incorrect, return false
        else {
            return false;
        }

        return (letterCheck && numberCheck);
    }

    // Check if intake placement it's inside placements.
    // e.g. "A14_B9_O15_" "A14"
    // return false
    static boolean isPlacementsWellFormed(String placements, String intakePlacement) {

        return false;
    }
}

