package com.stack.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	CyfroKradDobre.class,
	CyfroKradBledne.class,
	HultajChochlaBledne.class,
	HultajChochlaDobre.class,
	NieksztaltekBledne.class,
	NieksztaltekDobre.class,
	HeheszkiBledne.class,
	HeheszkiDobre.class,
	TititBledne.class,
	TititDobre.class})

public class AllTests { }