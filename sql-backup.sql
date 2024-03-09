--
-- PostgreSQL database dump
--

-- Dumped from database version 15.1
-- Dumped by pg_dump version 15.1

-- Started on 2024-03-09 16:01:11

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 214 (class 1259 OID 132910)
-- Name: carts; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.carts (
    id integer NOT NULL,
    total_price double precision NOT NULL,
    user_id integer DEFAULT 1 NOT NULL
);


ALTER TABLE public.carts OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 132914)
-- Name: carts_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.carts ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.carts_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 216 (class 1259 OID 132915)
-- Name: categories; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.categories (
    id integer NOT NULL,
    name character varying(50) NOT NULL
);


ALTER TABLE public.categories OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 132918)
-- Name: categories_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.categories ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.categories_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 226 (class 1259 OID 141048)
-- Name: order_products; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.order_products (
    order_id integer NOT NULL,
    quantity integer NOT NULL,
    unit_price double precision NOT NULL,
    product_id integer NOT NULL
);


ALTER TABLE public.order_products OWNER TO postgres;

--
-- TOC entry 225 (class 1259 OID 141038)
-- Name: orders; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.orders (
    id integer NOT NULL,
    user_id integer NOT NULL,
    date date NOT NULL
);


ALTER TABLE public.orders OWNER TO postgres;

--
-- TOC entry 224 (class 1259 OID 141037)
-- Name: orders_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.orders ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.orders_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 218 (class 1259 OID 132919)
-- Name: products; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.products (
    id integer NOT NULL,
    name character varying(50) NOT NULL,
    unitprice double precision NOT NULL,
    stock bigint DEFAULT 0 NOT NULL,
    category_id integer DEFAULT 4 NOT NULL
);


ALTER TABLE public.products OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 132924)
-- Name: products_carts; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.products_carts (
    id integer NOT NULL,
    cart_id integer NOT NULL,
    product_id integer NOT NULL,
    quantity integer NOT NULL
);


ALTER TABLE public.products_carts OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 132927)
-- Name: products_carts_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.products_carts ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.products_carts_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 221 (class 1259 OID 132928)
-- Name: products_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.products ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.products_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 222 (class 1259 OID 132929)
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    id integer NOT NULL,
    name character varying NOT NULL,
    last_name character varying NOT NULL,
    email character varying NOT NULL,
    country character varying DEFAULT 'Turkey'::character varying NOT NULL,
    city character varying DEFAULT 'Istanbul'::character varying NOT NULL
);


ALTER TABLE public.users OWNER TO postgres;

--
-- TOC entry 223 (class 1259 OID 132934)
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.users ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 3370 (class 0 OID 132910)
-- Dependencies: 214
-- Data for Name: carts; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.carts (id, total_price, user_id) OVERRIDING SYSTEM VALUE VALUES (3, 0, 1);
INSERT INTO public.carts (id, total_price, user_id) OVERRIDING SYSTEM VALUE VALUES (5, 100, 2);


--
-- TOC entry 3372 (class 0 OID 132915)
-- Dependencies: 216
-- Data for Name: categories; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.categories (id, name) OVERRIDING SYSTEM VALUE VALUES (2, 'Giyim');
INSERT INTO public.categories (id, name) OVERRIDING SYSTEM VALUE VALUES (4, 'Geçici Kategori');


--
-- TOC entry 3382 (class 0 OID 141048)
-- Dependencies: 226
-- Data for Name: order_products; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.order_products (order_id, quantity, unit_price, product_id) VALUES (1, 10, 50, 1);


--
-- TOC entry 3381 (class 0 OID 141038)
-- Dependencies: 225
-- Data for Name: orders; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.orders (id, user_id, date) OVERRIDING SYSTEM VALUE VALUES (1, 1, '2024-03-03');


--
-- TOC entry 3374 (class 0 OID 132919)
-- Dependencies: 218
-- Data for Name: products; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.products (id, name, unitprice, stock, category_id) OVERRIDING SYSTEM VALUE VALUES (1, 'Laptop', 5000, 10, 2);
INSERT INTO public.products (id, name, unitprice, stock, category_id) OVERRIDING SYSTEM VALUE VALUES (2, 'Tişört', 100, 50, 2);
INSERT INTO public.products (id, name, unitprice, stock, category_id) OVERRIDING SYSTEM VALUE VALUES (4, 'Mouse', 500, 0, 2);
INSERT INTO public.products (id, name, unitprice, stock, category_id) OVERRIDING SYSTEM VALUE VALUES (13, 'Deneme', 500, 0, 2);
INSERT INTO public.products (id, name, unitprice, stock, category_id) OVERRIDING SYSTEM VALUE VALUES (14, 'Kazak', 300, 2, 2);
INSERT INTO public.products (id, name, unitprice, stock, category_id) OVERRIDING SYSTEM VALUE VALUES (15, 'Moajsdjfjasdjase', 500, 0, 2);
INSERT INTO public.products (id, name, unitprice, stock, category_id) OVERRIDING SYSTEM VALUE VALUES (16, 'Moaae', 5, 0, 2);
INSERT INTO public.products (id, name, unitprice, stock, category_id) OVERRIDING SYSTEM VALUE VALUES (17, '%50 indirim!', 50, 0, 2);
INSERT INTO public.products (id, name, unitprice, stock, category_id) OVERRIDING SYSTEM VALUE VALUES (18, 'Insert Deneme', 500, 70, 4);
INSERT INTO public.products (id, name, unitprice, stock, category_id) OVERRIDING SYSTEM VALUE VALUES (20, 'API''dan eklendi', 500, 0, 4);
INSERT INTO public.products (id, name, unitprice, stock, category_id) OVERRIDING SYSTEM VALUE VALUES (21, 'Klavye', 50, 10, 2);
INSERT INTO public.products (id, name, unitprice, stock, category_id) OVERRIDING SYSTEM VALUE VALUES (22, 'Tabak', 30, 0, 2);


--
-- TOC entry 3375 (class 0 OID 132924)
-- Dependencies: 219
-- Data for Name: products_carts; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.products_carts (id, cart_id, product_id, quantity) OVERRIDING SYSTEM VALUE VALUES (1, 3, 1, 5);
INSERT INTO public.products_carts (id, cart_id, product_id, quantity) OVERRIDING SYSTEM VALUE VALUES (2, 3, 2, 10);
INSERT INTO public.products_carts (id, cart_id, product_id, quantity) OVERRIDING SYSTEM VALUE VALUES (3, 3, 1, 5);


--
-- TOC entry 3378 (class 0 OID 132929)
-- Dependencies: 222
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.users (id, name, last_name, email, country, city) OVERRIDING SYSTEM VALUE VALUES (1, 'halit enes', 'kalaycı', 'halit@kodlama.io', 'Turkey', 'Istanbul');
INSERT INTO public.users (id, name, last_name, email, country, city) OVERRIDING SYSTEM VALUE VALUES (2, 'Koray', 'Özgür', 'koray@turkcell.com', 'Turkey', 'Ankara');
INSERT INTO public.users (id, name, last_name, email, country, city) OVERRIDING SYSTEM VALUE VALUES (3, 'Dilara', 'Demircan', 'dilara@turkcell.com', 'Greece', '..');
INSERT INTO public.users (id, name, last_name, email, country, city) OVERRIDING SYSTEM VALUE VALUES (4, 'Taha', 'Hancı', 'taha@turkcell.com', 'Turkey', 'Istanbul');


--
-- TOC entry 3388 (class 0 OID 0)
-- Dependencies: 215
-- Name: carts_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.carts_id_seq', 5, true);


--
-- TOC entry 3389 (class 0 OID 0)
-- Dependencies: 217
-- Name: categories_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.categories_id_seq', 4, true);


--
-- TOC entry 3390 (class 0 OID 0)
-- Dependencies: 224
-- Name: orders_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.orders_id_seq', 1, true);


--
-- TOC entry 3391 (class 0 OID 0)
-- Dependencies: 220
-- Name: products_carts_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.products_carts_id_seq', 3, true);


--
-- TOC entry 3392 (class 0 OID 0)
-- Dependencies: 221
-- Name: products_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.products_id_seq', 22, true);


--
-- TOC entry 3393 (class 0 OID 0)
-- Dependencies: 223
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.users_id_seq', 4, true);


--
-- TOC entry 3220 (class 2606 OID 141064)
-- Name: order_products PK; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.order_products
    ADD CONSTRAINT "PK" PRIMARY KEY (product_id, order_id);


--
-- TOC entry 3208 (class 2606 OID 132936)
-- Name: carts carts_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.carts
    ADD CONSTRAINT carts_pkey PRIMARY KEY (id);


--
-- TOC entry 3210 (class 2606 OID 132938)
-- Name: categories categories_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.categories
    ADD CONSTRAINT categories_pkey PRIMARY KEY (id);


--
-- TOC entry 3218 (class 2606 OID 141042)
-- Name: orders orders_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orders
    ADD CONSTRAINT orders_pkey PRIMARY KEY (id);


--
-- TOC entry 3214 (class 2606 OID 132940)
-- Name: products_carts products_carts_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.products_carts
    ADD CONSTRAINT products_carts_pkey PRIMARY KEY (id);


--
-- TOC entry 3212 (class 2606 OID 132942)
-- Name: products products_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.products
    ADD CONSTRAINT products_pkey PRIMARY KEY (id);


--
-- TOC entry 3216 (class 2606 OID 132944)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- TOC entry 3223 (class 2606 OID 132945)
-- Name: products_carts FK_CART; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.products_carts
    ADD CONSTRAINT "FK_CART" FOREIGN KEY (cart_id) REFERENCES public.carts(id);


--
-- TOC entry 3226 (class 2606 OID 141058)
-- Name: order_products FK_ORDER_PRODUCT; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.order_products
    ADD CONSTRAINT "FK_ORDER_PRODUCT" FOREIGN KEY (order_id) REFERENCES public.orders(id);


--
-- TOC entry 3224 (class 2606 OID 132950)
-- Name: products_carts FK_PRODUCT; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.products_carts
    ADD CONSTRAINT "FK_PRODUCT" FOREIGN KEY (product_id) REFERENCES public.products(id);


--
-- TOC entry 3222 (class 2606 OID 132955)
-- Name: products FK_PRODUCTS_CATEGORIES; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.products
    ADD CONSTRAINT "FK_PRODUCTS_CATEGORIES" FOREIGN KEY (category_id) REFERENCES public.categories(id) ON DELETE SET DEFAULT NOT VALID;


--
-- TOC entry 3227 (class 2606 OID 141065)
-- Name: order_products FK_PRODUCT_ORDER; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.order_products
    ADD CONSTRAINT "FK_PRODUCT_ORDER" FOREIGN KEY (product_id) REFERENCES public.products(id) NOT VALID;


--
-- TOC entry 3221 (class 2606 OID 132960)
-- Name: carts FK_USERS_CARTS; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.carts
    ADD CONSTRAINT "FK_USERS_CARTS" FOREIGN KEY (user_id) REFERENCES public.users(id) NOT VALID;


--
-- TOC entry 3225 (class 2606 OID 141043)
-- Name: orders FK_USER_ORDER; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orders
    ADD CONSTRAINT "FK_USER_ORDER" FOREIGN KEY (user_id) REFERENCES public.users(id);


-- Completed on 2024-03-09 16:01:12

--
-- PostgreSQL database dump complete
--

