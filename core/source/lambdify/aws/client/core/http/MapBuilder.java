package lambdify.aws.client.core.http;

import java.util.*;
import lombok.*;

/**
 *
 */
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class MapBuilder<K, V> {

	final Map<K,V> data = new HashMap<>();

	public MapBuilder<K, V> put( K key, V value ) {
		data.put( key, value );
		return this;
	}

	public Map<K, V> build(){
		return data;
	}

	public static <V> MapBuilder<String, V> mapOf( Class<V> valueType ) {
		return new MapBuilder<>();
	}

	public static <K, V> MapBuilder<K, V> mapOf( Class<K> keyType, Class<V> valueType ){
		return new MapBuilder<>();
	}
}
