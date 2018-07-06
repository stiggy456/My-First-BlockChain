import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class BlockChain {

	public List<Block> getChain() {
		return chain;
	}

	public void setChain(List<Block> chain) {
		this.chain = chain;
	}

	private List<Block> chain;

	public BlockChain() {
		chain = new ArrayList<Block>();
		chain.add(genesisBlock());
		
	}
//Creation/Genesis block of the chain.
	private Block genesisBlock() {
		Block genesis = new Block("Genesis", new java.util.Date(), "<transactions>");
		genesis.setPreviousHash(null);
		genesis.computeHash();
		return genesis;

	}
//Adding blocks to the chain
	public void addBlock(Block blk) {
		Block newBlock = blk;
		newBlock.setPreviousHash(chain.get(chain.size()-1).getHash());
		newBlock.computeHash();
		this.chain.add(newBlock);
	}
		
	

	//Displaying the blockchain
	public void displayChain() {
		for(int i=0; i<chain.size(); i++) {
			System.out.println("Block:  " + i);
			System.out.println("Version:  " + chain.get(i).getVersion());
			System.out.println("Timestamp:  " + chain.get(i).getTimestamp());
			System.out.println("PreviousHash:  " + chain.get(i).getPreviousHash());
			System.out.println("Hash:  " + chain.get(i).getHash());
			System.out.println();
			
		}
	}
	
	//Getting the last block in the chain
	public Block getLatestBlock() {
		return this.chain.get(chain.size()-1);
		
	}
	
	//checking the to see if the block chain has been changed at all after it has run, validating that it hasn't been tampered with.
	public void isChainValid() {
		
		for(int i=chain.size()-1; i > 0; i--) {
			if( !(chain.get(i).getHash().equals(chain.get(i).computeHash()))) {
				System.out.println("Chain is not Valid!");
				return;
			}
				
			if( !(chain.get(i).getPreviousHash().equals(chain.get(i-1).computeHash()))) {
				System.out.println("Chain is not Valid!");
				return;
			}
		}
		
		System.out.println("Chain is Valid!");
	}
	
	
	//timer and running the block chain, currently not working for some reason!
	public void timer () {
		
		int MINUTES = 1; // The delay in minutes
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() { 			
					Block newBlock = Block;
					newBlock.setPreviousHash(chain.get(chain.size()-1).getHash());
					newBlock.computeHash();
					this.chain.add(newBlock);
				}
					
		}, 0, 1000 * 60 * MINUTES);
	}
}

