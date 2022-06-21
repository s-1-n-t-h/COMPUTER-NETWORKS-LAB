// package DVR;
import java.util.*;

class Node{

    int dist[];
    int from[];

    Node(int n){
        dist = new int[n];
        from = new int[n];
    }

}
public class DVRA {
    public static void main(String... args){
        int distMatrix[][] = new int[20][20];
        int n;
       
        System.out.println("No of Nodes: ");
        Scanner sc = new Scanner(System.in);
        n = Integer.parseInt(sc.nextLine());
        Node route[] = new Node[n];

        // Initialising objects in the array
        for( int i = 0; i < n; i++){
            route[i] = new Node(n);
        }
        System.out.println("Enter distance Matrix: ");
        for( int i = 0; i < n; i++){ // selectiong each node
            String[] inputArray = sc.nextLine().split(" ",0);
            for(int j = 0; j < n; j++){ // selecting each node in netowrk
                distMatrix[i][j] = Integer.parseInt(inputArray[j]);
                if( i == j){
                    distMatrix[i][j] = 0;
                }
                route[i].dist[j] = distMatrix[i][j]; // updating routig table for a particular node
                route[i].from[j] = j; // updating from which node the distance is from
            }

        }
        // implementation of bellman ford
        int flag;
        do{
            flag = 0;
            for(int i = 0; i < n; i++){
                for( int j = 0; j < n; j++){
                    for(int k = 0; k < n; k++){
                        if(route[i].dist[j] > (route[i].dist[k] + route[k].dist[j])){
                            route[i].dist[j] = route[i].dist[k] + route[k].dist[j];
                            route[i].from[j] = k;
                            flag = 1;
                        }
                    }
                }
            }
        }while(flag==1);
        // printing routing table at each node
        for(int i = 0; i< n ; i++){
            System.out.println("Router info for router: "+(i+1));
            System.out.println("Dest\tNext Hop\tDist");
            for(int j = 0; j < n; j++){
                System.out.println((j+1)+"\t"+(route[i].from[j]+1)+"\t\t"+route[i].dist[j]);
            }
        }

    }

}
