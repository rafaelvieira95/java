package br.ufc.crateus.eda.tries;
import br.ufc.crateus.eda.st.OrderedST;

public interface StringST<Value> extends OrderedST<String,Value> {

    String longestPrefixOf(String str);

    Iterable<String> keysWithPrefix(String str);

    Iterable <String> keysThatMatch(String key);

    Iterable <String> Keys();

}
