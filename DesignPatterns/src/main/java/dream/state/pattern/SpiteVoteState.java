package dream.state.pattern;

public class SpiteVoteState implements VoteState{

	@Override
	public void vote(String user, String voteItem, VoteManager voteManager) {
		String s = voteManager.getMapVote().get(user);
		if(s != null){
			voteManager.getMapVote().remove(user);
		}
		System.out.println("你有惡意灌票行為，取消投票資格！");
		
		if(voteManager.getMapVoteCount().get(user) >= 7){
			voteManager.getMapState().put(user, new BlackVoteState());
		}
	}
}
