package br.ufc.crateus.aps.decorator;

public class Character {

	private KindCharacter kind;

	public Character(KindCharacter kind) {
		this.kind = kind;
	}

	public KindCharacter getKind() {
		return kind;
	}

	public void setKind(KindCharacter kind) {
		this.kind = kind;
	}	
	
}
