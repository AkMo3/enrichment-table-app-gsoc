package org.nrnb.gsoc.enrichment.tasks;

import com.google.common.truth.Truth;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.cytoscape.application.swing.CytoPanelComponent2;
import org.cytoscape.model.CyNetwork;
import org.cytoscape.model.CyNetworkManager;
import org.cytoscape.service.util.CyServiceRegistrar;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Set;

public class EnrichmentTaskFactoryITTest {

    @Mock
    private CyNetworkManager cyNetworkManager;
    @Mock
    private CyServiceRegistrar registrar;
    @Mock
    private CytoPanelComponent2 enrichmentPanel;
    @Mock
    private Set<CyNetwork> cyNetworkSet;

    private EnrichmentTaskFactory enrichmentTaskFactory;
    private Boolean isReadyResult = false;

    private static AutoCloseable autoCloseable;

    @Before
    public void setup() {
        autoCloseable = MockitoAnnotations.openMocks(this);
    }

    @After
    public void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Given("Create a EnrichmentTaskFactory Object")
    public void setUp() {
        Mockito.when(registrar.getService(CyNetworkManager.class)).thenReturn(cyNetworkManager);
        enrichmentTaskFactory = new EnrichmentTaskFactory(registrar, enrichmentPanel);
    }

    @And("EnrichmentTaskFactory consists a CyNetworkManager which contains NetworkSet")
    public void objectContainsNetworkSet() {
        Mockito.when(cyNetworkManager.getNetworkSet()).thenReturn(cyNetworkSet);
    }

    @And("NetworkSet is not empty")
    public void networkSetIsNotEmpty() {
        Mockito.when(cyNetworkSet.size()).thenReturn(1);
    }

    @When("Request status of is EnrichmentTaskFactory ready")
    public void requestStatusOfIsEnrichmentTaskFactoryReady() {
        isReadyResult = enrichmentTaskFactory.isReady();
    }

    @Then("Returned value should be {string}")
    public void returnedValueShouldBe(String expectedResult) {
        Truth.assertThat(isReadyResult.toString()).isEqualTo(expectedResult);
    }
}
