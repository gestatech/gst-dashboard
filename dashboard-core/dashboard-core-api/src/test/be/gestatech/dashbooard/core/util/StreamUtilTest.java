package be.gestatech.dashbooard.core.util;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeTrue;

/**
 * Created by amuri on 4/30/2017.
 */
public class StreamUtilTest {
    @Before
    public void isEnabled() {
        assumeTrue(StreamUtil.isStreamSupported());
    }

    @Test
    public void shouldIdentifyStreamReturnType() throws Exception {
        Method empty = ArrayList.class.getMethod("stream");
        assertTrue(StreamUtil.isStreamReturned(empty));
    }

    @Test
    public void shouldReturnEmptyWhenGivenNull() throws Exception {
        Object expectedWrappedObject = StreamUtil.wrap(null);
        assertNull(expectedWrappedObject);
    }

    @Test
    public void shouldReturnAStreamWhenGivenACollection() throws Exception {
        Object wrapped = StreamUtil.wrap(Arrays.asList("a", "b"));
        Class<?> streamClass = Class.forName("java.util.stream.Stream");
        assertTrue(streamClass.isAssignableFrom(wrapped.getClass()));
    }
}