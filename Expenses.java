// Online Java Compiler
import java.util.Scanner;
class Main{
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int size,ch,count = 0;;
    
    System.out.println("Enter the number of Expense to record ");
    size = sc.nextInt();
    sc.nextLine();
    
    double[] expenses = new double[size];
    String[] descriptions = new String[size];
    String[] categories = new String[size];
    do
    {
        System.out.println("Expense Tracker Menu");
        System.out.println("1. Add Expense");
        System.out.println("2. Display Expense");
        System.out.println("3. Categorize Expense");
        System.out.println("4. Sort Expense");
        System.out.println("5. Search for an Expense");
        System.out.println("6. Exit");
        System.out.println("Please enter your choice");
        ch=sc.nextInt();
        sc.nextLine();
        switch(ch)
        {
        case 1:
            if(count < size)
            {
                System.out.println("Enter expense amount: ");
                expenses[count] = sc.nextDouble();
                sc.nextLine(); 
                System.out.println("Enter expense description: ");
                descriptions[count] = sc.nextLine();
                System.out.println("Expense Added !");
                count++;
            }
            else 
            {
                System.out.println("Expense limit reached! Cannot add more.");
            }
            break;
        case 2:// display expense
            if (count == 0)
            {
                System.out.println("No expenses recorded!");
            }
            else
            {
                System.out.println("Recorded Expenses:");
                for (int i = 0; i < count; i++)
                {
                    System.out.println("Amount: " + expenses[i] + ", Description: " + descriptions[i]);
                }
            }
            break;
        case 3:
             if (count == 0)
             {
                 System.out.println("No expenses recorded!");
             } 
             else
             {
                categorizeExpenses(expenses, categories, count);
                System.out.println("Expense Categories:");
                for (int i = 0; i < count; i++) 
                {
                    System.out.println(descriptions[i] + " falls under the category " + categories[i]);
                }
             }
            break;
        case 4: // sort expense
            if (count > 0)
            {
                sortbyPrice(descriptions, expenses, count);
                //displayTask(taskNames,estimatedMinutes,count);
            }
            else
            {
                System.out.println("No expenses recorded");
            }
            break;
        case 5: //search for an expense
            if (count > 0)
            { 
                System.out.print("Enter description name to search: ");
                String searchdescription = sc.nextLine();
                int index=searchbydescription(descriptions, count, searchdescription);
                if(index!=-1)
                { 
                    //3System.out.println("Description Name: " + descriptions[index]);
                    System.out.println("Amount: " + expenses[index] + ", Description: " + descriptions[index]);
                    //System.out.println("Description found at position: " + index);
                    
                }
                else
                { 
                    System.out.println("Expenses not found.");
                }
            }
            else
            {
                System.out.println("No expenses recorded yet to categorize.");
                
            }   
            break;
        case 6:
            System.out.println(" Exiting Expense Tracker");
            break;
        default :
             System.out.println(" Invalid choice! Please enter a valid option");
    } 
    }
    while(ch!=6);
    
     sc.close();
    }
    
    public static void sortbyPrice(String[] descriptions, double[] expenses, int count)
    {
        for (int i = 0; i < count - 1; i++) 
        {
            for (int j = 0; j < count - i - 1; j++)
            { // Compare adjacent elements
                if (expenses[j] > expenses[j + 1])
                {
                    double tempAmount = expenses[j];
                    expenses[j] = expenses[j + 1];
                    expenses[j + 1] = tempAmount;
                    String tempDescription = descriptions[j];
                    descriptions[j] = descriptions[j + 1];
                    descriptions[j + 1] = tempDescription;
                }
            }
        }
        System.out.println("Expenses sorted successfully!");
        for (int i = 0; i < count; i++)
                {
                    System.out.println("Amount: " + expenses[i] + ", Description: " + descriptions[i]);
                }
    }


    
    public static int searchbydescription(String[] descriptions,int count, String searchdescription)
    {
        int index = -1;
        for (int i = 0; i < count; i++) 
        {
            if (descriptions[i].equals(searchdescription))
            {
                index=i;
                break;
            }
        }
        return index;
    }

    
    private static void categorizeExpenses(double[] expenses, String[] categories, int count) {
        for (int i = 0; i < count; i++) {
            if (expenses[i] < 500) {
                categories[i] = "Low expense";
            } else if (expenses[i] < 1999) {
                categories[i] = "Moderate expense";
            } else {
                categories[i] = "High expense";
            }
        }
    }
        
    }