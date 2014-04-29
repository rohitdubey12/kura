/**
 * Copyright (c) 2011, 2014 Eurotech and/or its affiliates
 *
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Eurotech
 */
package org.eclipse.kura.linux.net.modem;

import org.eclipse.kura.core.linux.util.LinuxProcessUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsbModemDriver {
	
	private static final Logger s_logger = LoggerFactory.getLogger(UsbModemDriver.class);
	
	private String m_name;
	
	public UsbModemDriver (String name) {
		m_name = name;
	}
	
	public int install() throws Exception {
		s_logger.info("installing driver: " + m_name);
		return LinuxProcessUtil.start("modprobe " + m_name, true);
	}
	
	public int remove() throws Exception {
		s_logger.info("removing driver: " + m_name);
		return LinuxProcessUtil.start("rmmod " + m_name, true);
	}

	public String getName() {
		return m_name;
	}
}
