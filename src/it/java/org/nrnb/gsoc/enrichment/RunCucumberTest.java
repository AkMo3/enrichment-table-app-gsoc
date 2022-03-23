package org.nrnb.gsoc.enrichment;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectDirectories;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectDirectories("src/it/resources/org/nrnb/gsoc/enrichment/tasks")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "org.nrnb.gsoc.enrichment.tasks")
public class RunCucumberTest {
}
