package com.swayam.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "features", glue = { "com.swayam.steps" }, tags = {
		"@CourseOutline-Assessment" }, monochrome = true, plugin = {
				"json:target/cucumber-report/cucumber.json" }, dryRun = false)
// ,
// "rerun:rerun/failed_scenarios.txt" }, dryRun = false)

public class Runner extends AbstractTestNGCucumberTests {

}