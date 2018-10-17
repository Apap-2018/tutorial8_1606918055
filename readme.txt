1. Karena constraint pilot pada table FlightModel untuk dapat di flush ke DB
   memerlukan PilotModel.

2. Ketika entity manager melakukan commit ke DB akan terjadi error karena
   foreign key pilot bernilai null

3. Mockito melakukan mock hasil dari fungsi findByFlightNumber milik flightDb dengan flight yang sudah
   dibuat sebelumnya sehingga ketika fungsi tersebut dipanggil tidak akan melakukan proses
   yang biasanya ia kerjakan, namun langsung mengembalikan nilai flight yang di mock.

4. Mockito melakukan mock hasil dari fungsi getFlightDetailByFlightNumber milik flightService
   dengan flight yang sudah dibuat sebelumnya sehingga ketika fungsi tersebut dipanggil tidak akan melakukan proses
   yang biasanya ia kerjakan, namun langsung mengembalikan nilai flight yang di mock.

5. MVC mock melakukan assert bahwa request yang dilakukan memiliki hasil dengan
   expektasi status code 200 (isOk)

6. MVC mock melakukan assert bahwa hasil request yaitu json memiliki key pada body, yaitu flightNumber
   bernilai sama dengan flightNumber fligtModel yang sebelumnya dibuat. Kita melakukan test bahwa flight
   yang kita mock untuk flightController sama dengan yang kita buat.

7. anotasi @ResponseBody pada mapping /flight/view memberikan kemampuan pada fungsi untuk mengembalikan
   response berupa JSON dengan cara melakukan serialize setelah me-return pbject dan diberikan ke respon http.

JMeter explanation
Dengan konfigurasi thread group yang sama yaitu 50, 10, 1, tidak ada request yang gagal (merah).
Sehingga tidak dapat dijelaskan kenapa ada request yang gagal (merah).

Berikut log hasil load test:

1	18:46:24.935	Thread Group 1-1	HTTP Request	7039	Success	524630	147	77	    3
2	18:46:25.132	Thread Group 1-2	HTTP Request	7649	Success	524630	147	47	    1
3	18:46:25.333	Thread Group 1-3	HTTP Request	8136	Success	524630	147	59	    0
4	18:46:25.534	Thread Group 1-4	HTTP Request	8258	Success	524630	147	75	    0
5	18:46:25.735	Thread Group 1-5	HTTP Request	8546	Success	524630	147	76	    0
6	18:46:25.937	Thread Group 1-6	HTTP Request	9014	Success	524630	147	117	    0
7	18:46:26.137	Thread Group 1-7	HTTP Request	9117	Success	524630	147	107	    0
8	18:46:26.336	Thread Group 1-8	HTTP Request	9297	Success	524630	147	104	    0
9	18:46:26.539	Thread Group 1-9	HTTP Request	9262	Success	524630	147	156	    0
10	18:46:26.739	Thread Group 1-10	HTTP Request	9234	Success	524630	147	155	    1
11	18:46:26.943	Thread Group 1-11	HTTP Request	14445	Success	524630	147	5215	1
12	18:46:27.151	Thread Group 1-12	HTTP Request	14294	Success	524630	147	5758	0
13	18:46:27.352	Thread Group 1-13	HTTP Request	14854	Success	524630	147	6370	1
14	18:46:27.557	Thread Group 1-14	HTTP Request	15258	Success	524630	147	6440	0
15	18:46:27.758	Thread Group 1-15	HTTP Request	15154	Success	524630	147	6623	0
16	18:46:27.958	Thread Group 1-16	HTTP Request	16018	Success	524630	147	7196	1
17	18:46:28.158	Thread Group 1-17	HTTP Request	16226	Success	524630	147	7197	0
18	18:46:28.360	Thread Group 1-18	HTTP Request	16144	Success	524630	147	7438	0
19	18:46:28.766	Thread Group 1-20	HTTP Request	15755	Success	524630	147	7325	0
20	18:46:28.566	Thread Group 1-19	HTTP Request	16193	Success	524630	147	7487	0
21	18:46:28.966	Thread Group 1-21	HTTP Request	21182	Success	524630	147	12674	0
22	18:46:29.167	Thread Group 1-22	HTTP Request	21316	Success	524630	147	12509	0
23	18:46:29.368	Thread Group 1-23	HTTP Request	21269	Success	524630	147	12925	0
24	18:46:29.768	Thread Group 1-25	HTTP Request	21682	Success	524630	147	13331	0
25	18:46:29.567	Thread Group 1-24	HTTP Request	21897	Success	524630	147	13399	1
26	18:46:29.968	Thread Group 1-26	HTTP Request	22370	Success	524630	147	14185	0
27	18:46:30.168	Thread Group 1-27	HTTP Request	22679	Success	524630	147	14404	0
28	18:46:30.367	Thread Group 1-28	HTTP Request	22584	Success	524630	147	14224	0
29	18:46:30.568	Thread Group 1-29	HTTP Request	22853	Success	524630	147	14127	1
30	18:46:30.768	Thread Group 1-30	HTTP Request	23121	Success	524630	147	14133	1
31	18:46:30.969	Thread Group 1-31	HTTP Request	27814	Success	524630	147	19301	0
32	18:46:31.380	Thread Group 1-33	HTTP Request	27985	Success	524630	147	19384	0
33	18:46:31.175	Thread Group 1-32	HTTP Request	28321	Success	524630	147	19493	0
34	18:46:31.577	Thread Group 1-34	HTTP Request	28642	Success	524630	147	20038	1
35	18:46:31.781	Thread Group 1-35	HTTP Request	28719	Success	524630	147	19834	1
36	18:46:31.980	Thread Group 1-36	HTTP Request	29180	Success	524630	147	20471	1
37	18:46:32.380	Thread Group 1-38	HTTP Request	29474	Success	524630	147	20676	1
38	18:46:32.180	Thread Group 1-37	HTTP Request	30050	Success	524630	147	20859	1
39	18:46:32.584	Thread Group 1-39	HTTP Request	30209	Success	524630	147	21035	0
40	18:46:32.787	Thread Group 1-40	HTTP Request	30678	Success	524630	147	21362	1
41	18:46:32.990	Thread Group 1-41	HTTP Request	35262	Success	524630	147	25909	2
42	18:46:33.389	Thread Group 1-43	HTTP Request	35705	Success	524630	147	26214	0
43	18:46:33.192	Thread Group 1-42	HTTP Request	36140	Success	524630	147	26408	3
44	18:46:33.593	Thread Group 1-44	HTTP Request	35880	Success	524630	147	26759	2
45	18:46:33.791	Thread Group 1-45	HTTP Request	36207	Success	524630	147	26821	0
46	18:46:33.996	Thread Group 1-46	HTTP Request	36621	Success	524630	147	27358	0
47	18:46:34.192	Thread Group 1-47	HTTP Request	36517	Success	524630	147	27850	0
48	18:46:34.394	Thread Group 1-48	HTTP Request	36340	Success	524630	147	28025	0
49	18:46:34.594	Thread Group 1-49	HTTP Request	36217	Success	524630	147	28311	0
50	18:46:34.794	Thread Group 1-50	HTTP Request	36123	Success	524630	147	28847	1