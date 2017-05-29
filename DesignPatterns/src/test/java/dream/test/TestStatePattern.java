package dream.test;

import org.junit.Test;
import org.junit.Assert;

import dream.state.pattern.BlackVoteState;
import dream.state.pattern.VoteManager;

public class TestStatePattern {
	@Test
	public void TestVote(){
		//Arrange
		VoteManager vm = new VoteManager();
		
		//Act
		for(int i = 0 ; i < 8; i++){
			vm.vote("Tom", "AAA");
		}
		
		//Assert
		Assert.assertEquals(vm.getMapState().get("Tom").getClass(), BlackVoteState.class);
	}
}
