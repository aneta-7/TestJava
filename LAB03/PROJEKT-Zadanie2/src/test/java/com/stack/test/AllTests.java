package com.stack.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	CyfrokradTest.class,
	HultajChochlaTest.class,
	NieksztaltekTest.class,
	HeheszkiTest.class,
	TititTest.class})

public class AllTests { }