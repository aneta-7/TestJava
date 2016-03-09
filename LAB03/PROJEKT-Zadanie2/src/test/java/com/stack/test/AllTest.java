package com.stack.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	CyfroKradDobre.class,
	CyfroKradBledne.class,
	CyfroKradZParametrem.class,
	HultajChochlaBledne.class,
	HultajChochlaDobre.class,
	HultajChochlaZParametrem.class,
	NieksztaltekBledne.class,
	NieksztaltekDobre.class,
	NiekształtekZParametrem.class,
	HeheszkiBledne.class,
	HeheszkiDobre.class,
	HeheszkiZParametrem.class,
	TititBledne.class,
	TititDobre.class,
	TititZParametrem.class})

public class AllTest { }