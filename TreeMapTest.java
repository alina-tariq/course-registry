import java.util.*;

public class TreeMapTest {

    public static void main(String[] args) {

	String[][] timetable = new String[6][10];
		
	// day 
	timetable[0][0] = "        "; timetable[1][0] = "  MON   ";
	timetable[2][0] = "  TUE   "; timetable[3][0] = "  WED   ";
	timetable[4][0] = "  THU   "; timetable[5][0] = "  FRI   ";
		
	// time 
	timetable[0][1] = "  0800  "; timetable[0][2] = "  0900  ";
	timetable[0][3] = "  1000  "; timetable[0][4] = "  1100  ";
	timetable[0][5] = "  1200  "; timetable[0][6] = "  1300  ";
	timetable[0][7] = "  1400  "; timetable[0][8] = "  1500  ";
	timetable[0][9] = "  1600  ";

	for (int i = 1; i < 6; i++) {
	    for (int j = 1; j < 10; j++){
		timetable[i][j] = " CPS209 ";
	    }
	}

	for (int j = 0; j < 10; j++) {
	    for (int i = 0; i < 6; i++) {
		System.out.print(timetable[i][j]);
	    }
	    System.out.print("\n");
	}
	
    }

}
