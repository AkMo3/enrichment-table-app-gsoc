package org.nrnb.gsoc.enrichment.tasks;

import com.google.common.truth.Truth;
import org.cytoscape.application.swing.CytoPanelComponent2;
import org.cytoscape.model.CyNetwork;
import org.cytoscape.model.CyNetworkManager;
import org.cytoscape.service.util.CyServiceRegistrar;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.nrnb.gsoc.enrichment.AbstractTestSupportFramework;

import java.util.Set;

public class EnrichmentTaskFactoryTest extends AbstractTestSupportFramework {

    @Mock private CyNetworkManager cyNetworkManager;
    @Mock private CyServiceRegistrar registrar;
    @Mock private CytoPanelComponent2 enrichmentPanel;

    @Mock private Set<CyNetwork> cyNetworkSet;
    private EnrichmentTaskFactory enrichmentTaskFactory;

    @BeforeEach
    public void initMocks() {
        Mockito.when(registrar.getService(CyNetworkManager.class)).thenReturn(cyNetworkManager);
        enrichmentTaskFactory = new EnrichmentTaskFactory(registrar, enrichmentPanel);
    }

    @Test
    public void testIsEnrichmentFactoryReadyTest() {
        Mockito.when(cyNetworkManager.getNetworkSet()).thenReturn(cyNetworkSet);
        Mockito.when(cyNetworkSet.size()).thenReturn(5);
        Truth.assertThat(enrichmentTaskFactory.isReady()).isTrue();
    }

    @Test
    public void testIsEnrichmentFactoryReady2Test() {
        Mockito.when(cyNetworkManager.getNetworkSet()).thenReturn(cyNetworkSet);
        Mockito.when(cyNetworkSet.size()).thenReturn(0);
        Truth.assertThat(enrichmentTaskFactory.isReady()).isFalse();
    }

    @Test
    public void testIsEnrichmentFactoryReady3Test() {
        Mockito.when(cyNetworkManager.getNetworkSet()).thenReturn(null);
        Truth.assertThat(enrichmentTaskFactory.isReady()).isFalse();
    }
}
