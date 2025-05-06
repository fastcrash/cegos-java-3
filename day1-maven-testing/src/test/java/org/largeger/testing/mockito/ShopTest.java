package org.largeger.testing.mockito;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ShopTest {

    @Mock
    Database databaseMock;

    @Before
    public void setup() {
        assertNotNull(databaseMock);
        when(databaseMock.isAvailable()).thenReturn(true);
    }

    @Test
    void testQuery() {
        Shop s = new Shop(databaseMock);
        assertTrue(s.query("SELECT * from s"));
    }
}
