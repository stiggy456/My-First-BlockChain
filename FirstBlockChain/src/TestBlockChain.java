		
public class TestBlockChain {
	

		
		public static void main(String args[]) {
			BlockChain DDPCoin = new BlockChain();

			//creating blocks in the blockchain.
			Block a = new Block("1.0", new java.util.Date(), "<transactions>");
			Block b = new Block("1.0", new java.util.Date(), "<transactions>");
			Block c = new Block("1.0", new java.util.Date(), "<transactions>");

			//adding blocks to the chain
			DDPCoin.addBlock(a);
			DDPCoin.addBlock(b);
			DDPCoin.addBlock(c);

			//Displaying the block chain
			DDPCoin.displayChain();
			
			//Making sure the chain is valid
			DDPCoin.isChainValid();
			
			//attempting to make the chain add a new block every few minutes
			DDPCoin.timer();
				
			//to do add block after timer has run? need a new method?
				
				
			}

		
	
}


