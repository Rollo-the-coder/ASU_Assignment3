// CSE 110     : <Spring 2021>
// Assignment  : <assignment #3>
// Author      : <Erik Christian Gotta> & <1222628953>
// Description : <Code that computes whether you should buy, sell or a hold stock and how much>

package Assignment03;
import java.util.Scanner;

public class Assignment03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //input collection
        System.out.print("Current Shares  : ");
        int currentShares = sc.nextInt();

        System.out.print("Purchase Price  : ");
        int purchasePrice = sc.nextInt();

        System.out.print("Market Price    : ");
        int marketPrice = sc.nextInt();

        System.out.print("Available Funds : ");
        int availableFunds = sc.nextInt();


        //Math calculations
        int transactionFee = 10;
        //used in deciding how many shares to buy with explicit conversion
        double numberOfSharesToBuy = Math.floor((availableFunds - transactionFee) / marketPrice);
        int castNumberOfSharesToBuy = (int) numberOfSharesToBuy;
        
        //Currently an un-used variable
        double totalBuyCost = transactionFee + marketPrice * numberOfSharesToBuy;

        //cost of each share
        double perShareBuyValue = purchasePrice - marketPrice;

        //we should buy if total value of shares is greater than transaction fee
        double totalBuyValue = perShareBuyValue * numberOfSharesToBuy;

        //sell value must be hired then value paid plus cover transaction fee
        double perShareSellValue = marketPrice - purchasePrice;
        double totalSellValue = perShareSellValue * currentShares;

        //to calculate shares being sold with explicit type cast
        double numberOfSharesToSell = Math.floor((perShareSellValue * currentShares) - transactionFee);
        int castNumberOfSharesToSell = (int) numberOfSharesToSell;

        //Selection Control Statements based off of math above
        //if for buying
        if ((availableFunds > transactionFee) && (perShareBuyValue >= marketPrice)) 
        {
            if (totalBuyValue > transactionFee) 
            {
                System.out.println("Buy " + castNumberOfSharesToBuy + " shares");
            }
            else
            {
                System.out.println("Hold shares");
            }
        } 
        //else if for selling
        else if (marketPrice > perShareSellValue)
        {
            if (totalSellValue > transactionFee) 
            {
                System.out.println("Sell " + castNumberOfSharesToSell + " shares");
            }
            else
            {
                System.out.println("Hold shares");
            }
        } 
        else 
        {
            System.out.println("Hold shares");
        }


        sc.close();
    }
}