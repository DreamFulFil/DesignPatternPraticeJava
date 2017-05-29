package dream.state.pattern;

import java.util.HashMap;
import java.util.Map;

public class VoteManager {
	private Map<String, VoteState> mapState = new HashMap<>();
	private Map<String, String> mapVote = new HashMap<>();
	private Map<String, Integer> mapVoteCount = new HashMap<>();
	
	public Map<String, String> getMapVote(){return mapVote;}
	public Map<String, VoteState> getMapState(){ return mapState;}
	public Map<String, Integer> getMapVoteCount(){return mapVoteCount;}
	
	public void vote(String user, String voteItem){
		Integer oldVoteCount = mapVoteCount.get(user);
		if(oldVoteCount == null){
			oldVoteCount = 0;//AutoBoxing
		}
		oldVoteCount++;
		mapVoteCount.put(user, oldVoteCount);
		
		VoteState state = mapState.get(user);
		if(state == null)
			state = new NormalState();
		
		state.vote(user, voteItem, this);
	}
}
