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
        //used in buy part of if statment
        double numberOfSharesToBuy = Math.floor((availableFunds - transactionFee) / marketPrice);
        
        //used in solving if should buy or not?
        double totalBuyCost = transactionFee + marketPrice * numberOfSharesToBuy;
        //cost of each share
        double perShareBuyValue = purchasePrice - marketPrice;

        //we should buy if total value of shares is greater than transaction fee
        double totalBuyValue = perShareBuyValue * numberOfSharesToBuy;

        //sell value must be hired then value paid plus cover transaction fee
        double perShareSellValue = marketPrice - purchasePrice;
        double totalSellValue = perShareSellValue * currentShares;

        double numberOfSharesToSell = Math.floor((perShareSellValue * currentShares) - transactionFee);

        //Selection Control Statements based off of math above
        //need to adjust fee check to be after calculating sell to pay for fee
        if ((availableFunds > transactionFee) && (perShareBuyValue >= marketPrice)) //(current market price per share + ??fee math problem < purchas price per share of stock on current acocunt)
        {
            if (totalBuyValue > transactionFee) 
            {
                System.out.println("Buy " + numberOfSharesToBuy + " shares");
            }
            else
            {
                System.out.println("Hold shares1");
            }
        } 
        else if (marketPrice > perShareSellValue)
        {
            if (totalSellValue > transactionFee) 
            {
                System.out.println("Sell " + numberOfSharesToSell + " shares");
            }
            else
            {
                System.out.println("Hold shares2");
            }
        } 
        else 
        {
            System.out.println("Hold shares3");
        }


        sc.close();
    }
}