import pieces.PiecesMain;

public class Table {
    int[][] table=new int[9][12];
    Point point=new Point(5,2);
    PiecesMain piece;

    







public void printTable(){
    for(int i=0;i<table.length;i++){
     for(int j=0;j< table[0].length;j++){
         System.out.print(table[i][j]);
         System.out.print(" ");
        }
        System.out.println();
    }
}
}
