package dream.state.pattern;

public class SpiteVoteState implements VoteState{

	@Override
	public void vote(String user, String voteItem, VoteManager voteManager) {
		String s = voteManager.getMapVote().get(user);
		if(s != null){
			voteManager.getMapVote().remove(user);
		}
		System.out.println("�A���c�N�鲼�欰�A�����벼���I");
		
		if(voteManager.getMapVoteCount().get(user) >= 7){
			voteManager.getMapState().put(user, new BlackVoteState());
		}
	}
}
