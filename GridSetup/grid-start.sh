#!/bin/bash
echo "==============================================="
echo "  Starting Selenium Grid 4.24.0 (Hub + Node + Standalone)"
echo "==============================================="

./hub.sh
sleep 5
./node.sh
sleep 5
./standalone.sh

echo ""
echo "Selenium Grid is running!"
echo "Hub:         http://localhost:4444/ui"
echo "Node Port:   5556"
echo "Standalone:  http://localhost:6666/ui"
echo ""
